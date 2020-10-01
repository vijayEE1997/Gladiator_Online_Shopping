import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserEditProfileComponent } from './user-edit-profile.component';

describe('UserEditProfileComponent', () => {
  let component: UserEditProfileComponent;
  let fixture: ComponentFixture<UserEditProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserEditProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserEditProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
