import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AppOpt} from '../model/appopt';
import {AppOptService} from '../services/appopt.service';

@Component({
    selector: 'app-appopt-list',
    templateUrl: './appopt-list.component.html',
    styleUrls: ['./appopt-list.component.css']
})
export class AppOptListComponent implements OnInit {
    appopts: AppOpt[];
    appopt: AppOpt;
    appoptId: String;
    errorMessage = "";


    constructor(
        private appOptService: AppOptService,
        private route: ActivatedRoute,
        private router: Router) {
    }


    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            if (params.has("appopt.id")) {
                this.appoptId = params.get("appopt.id")!;
                this.appOptService.findAppOpt(params.get("appopt.id"))
                    .subscribe(
                        (response) => {
                            this.appopt = response;
                        },
                        (error) => {
                            this.errorMessage = error;
                        }
                    )
            } else {
                this.appOptService.listAppOpts()
                    .subscribe(
                        (response) => {
                            this.appopts = response;
                        },
                        (error) => {
                            this.errorMessage = error;
                        }
                    )
            }
        })

    }

    gotoAppOptList() {
        this.router.navigate(["/appopts", this.appoptId, 'list']);
    }

    gotoAppOptEdit(id: String) {
        this.router.navigate(["/appopts", id, 'edit']);
    }

    gotoAppOptNew() {
        this.router.navigate(["/appopts", 'new']);
    }
}
