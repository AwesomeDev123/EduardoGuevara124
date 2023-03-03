import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AppOptFormComponent} from './appopt-form.component';

describe('AppoptFormComponent', () => {
    let component: AppOptFormComponent;
    let fixture: ComponentFixture<AppOptFormComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [AppOptFormComponent]
        })
            .compileComponents();

        fixture = TestBed.createComponent(AppOptFormComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
