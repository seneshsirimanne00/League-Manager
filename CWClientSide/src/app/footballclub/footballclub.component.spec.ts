import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FootballclubComponent } from './footballclub.component';

describe('FootballclubComponent', () => {
  let component: FootballclubComponent;
  let fixture: ComponentFixture<FootballclubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FootballclubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FootballclubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
