import { Component } from '@angular/core';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {NgOptimizedImage} from "@angular/common";
import {MatTab, MatTabGroup} from "@angular/material/tabs";
import {HeaderMenuComponent} from "../header-menu/header-menu.component";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.css',
  standalone: true,
  imports: [MatToolbarModule, MatButtonModule, MatIconModule, NgOptimizedImage, MatTabGroup, MatTab, HeaderMenuComponent]
})
export class MainPageComponent {

}
