import {Component, OnInit} from '@angular/core';
import {Destination} from '../../interface/destination';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DestinationService} from '../../_services/des.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  public editorValue = '';
  desList: Destination[] = [];
  failMessage!: string;
  successMessage!: string;
  desForm!: FormGroup;
  public text: any = '';
  constructor(private desService: DestinationService,
              private router: Router) {

  }

  ngOnInit(): void {
    this.desForm = new FormGroup(
      {
        Name: new FormControl('',
          [Validators.required,
            Validators.minLength(5)]),
        country: new FormControl('',
          [Validators.required,
            Validators.minLength(5)]),
        province: new FormControl('',
          [Validators.required,
            Validators.minLength(5)]),
        address: new FormControl('',
          [Validators.required,
            Validators.minLength(5)]),
        description: new FormControl('',
          [Validators.required,
            Validators.minLength(5)]),
      }
    );
  }
  onSubmit(): void {
    if (this.desForm.valid) {
      const {value} = this.desForm;
      this.desService.createDes(value)
        .subscribe(result => {
          this.desList.push(result);
          this.router.navigate(['destination/list']);
          this.successMessage = 'successfully !';
        }, error => {
          this.failMessage = 'Fail !';
        });
    }
    console.log(this.editorValue);

  }
}
