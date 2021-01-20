import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {CommonModule} from '@angular/common';
import {ListComponent} from './list/list.component';
import {NgModule} from '@angular/core';

const routes: Routes = [
  {
    path: 'list',
    component: ListComponent
  }
];

@NgModule({
  declarations: [ListComponent],
    imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,
    ReactiveFormsModule
  ]
})
export class DestinationModule {
}
