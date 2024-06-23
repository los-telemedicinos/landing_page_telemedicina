import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTimeDoctorComponent } from './list-time-doctor.component';

describe('ListTimeDoctorComponent', () => {
  let component: ListTimeDoctorComponent;
  let fixture: ComponentFixture<ListTimeDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListTimeDoctorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListTimeDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
