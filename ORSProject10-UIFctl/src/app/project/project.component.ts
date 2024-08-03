import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {

    super(locator.endpoints.PROJECT, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.category);
    flag = flag && validator.isNotNullObject(form.openDate);
    flag = flag && validator.isNotNullObject(form.version);

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
    form.name = data.name;
    form.category = data.category;
    form.openDate = this.parseDate(data.openDate);
    form.version = data.version;

  }
  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }
 

}
