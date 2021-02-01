import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {CommonModule} from '@angular/common';
import {ListComponent} from './list/list.component';
import {NgModule} from '@angular/core';
import { CreateComponent } from './create/create.component';
import {CKEditorModule} from 'ngx-ckeditor';
import {ReviewComponent} from './review/review.component';


const routes: Routes = [
  {
    path: 'list',
    component: ListComponent
  },
  {
    path: 'create',
    component: CreateComponent
  },
  {
    path: 'review/:id',
    component: ReviewComponent
  }
];

@NgModule({
  declarations: [ListComponent, CreateComponent, ReviewComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,
    ReactiveFormsModule,
    CKEditorModule
  ]
})
export class DestinationModule {

}
