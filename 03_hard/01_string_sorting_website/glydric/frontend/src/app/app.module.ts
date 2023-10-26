import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {FormComponent} from "./form/form.component";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    FormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap:
    [FormComponent]
})

export class AppModule {
}
