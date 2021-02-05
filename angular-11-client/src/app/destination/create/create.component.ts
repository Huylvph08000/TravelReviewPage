import {Component, OnInit} from '@angular/core';
import {Destination} from '../../interface/destination';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DestinationService} from '../../_services/des.service';
import {Router} from '@angular/router';
import {TokenStorageService} from '../../_services/token-storage.service';
import {HttpClient} from '@angular/common/http';


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
  public id = '';
  selectedFile!: File;
  imageName: any;
  message!: string;

  constructor(private desService: DestinationService,
              private router: Router, private tokenStorageService: TokenStorageService, private httpClient: HttpClient) {

  }


  onFileChange(event: any): any {
    this.selectedFile = event.target.files[0];
  }

  ngOnInit(): void {
    const user = this.tokenStorageService.getUser();
    this.id = user.id;
    this.desForm = new FormGroup(
      {
        user: new FormGroup({
          id: new FormControl(),
        }),
        id: new FormControl(''),
        name: new FormControl('',
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
        shortDescription: new FormControl('',
          [Validators.required,
            Validators.minLength(5)]),
        description: new FormControl('',
          [Validators.required,
            Validators.minLength(5)]),
      }
    );
  }

  public onFileChanged(event: { target: { files: File[]; }; }) {
    this.selectedFile = event.target.files[0];
  }

  onUpload() {
    console.log(this.selectedFile);
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
    this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
          if (response.status === 200) {
            this.message = 'Image uploaded successfully';
          } else {
            this.message = 'Image not uploaded successfully';
          }
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
  }
}
