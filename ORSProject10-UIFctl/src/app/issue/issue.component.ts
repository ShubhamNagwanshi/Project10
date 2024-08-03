import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {

    super(locator.endpoints.ISSUE, locator, route); }

    validateForm(form) {

      let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.openDate);
    flag = flag && validator.isNotNullObject(form.title);
    flag = flag && validator.isNotNullObject(form.description);
    flag = flag && validator.isNotNullObject(form.assignTo);
    flag = flag && validator.isNotNullObject(form.status);


    return flag;
        
    }

    limitInput(event: any, maxLength: number) {
      const target = event.target;
      const value = target.value;
      if (value.length >= maxLength) {
        event.preventDefault();
      } else if (!/^\d*$/.test(event.key)) {
  
        event.preventDefault();
      }
    }

    populateForm(form, data) {

      form.id = data.id;
      form.openDate = this.parseDate(data.openDate);
      form.title = data.title;
      form.description = data.description;
      form.assignTo = data.assignTo;
      form.status = data.status;
  
    }

    parseDate(dateString: string): Date {
      if (dateString) {
        return new Date(dateString);
      }
      return null;
    }

}
