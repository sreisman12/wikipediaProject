import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleBrowserComponent } from './article-browser.component';

describe('ArticleBrowserComponent', () => {
  let component: ArticleBrowserComponent;
  let fixture: ComponentFixture<ArticleBrowserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleBrowserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleBrowserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
