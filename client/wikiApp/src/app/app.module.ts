import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ArticleBrowserComponent } from './article-browser/article-browser.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticleBrowserComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
