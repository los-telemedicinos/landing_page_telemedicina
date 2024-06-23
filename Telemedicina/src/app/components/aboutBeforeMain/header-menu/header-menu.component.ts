import { Component } from '@angular/core';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {NgOptimizedImage} from "@angular/common";
import {MatTab, MatTabGroup} from "@angular/material/tabs";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-header-menu',
  templateUrl: './header-menu.component.html',
  styleUrl: './header-menu.component.css',
  standalone: true,
  imports: [MatToolbarModule, MatButtonModule, MatIconModule, NgOptimizedImage, MatTabGroup, MatTab, RouterLink]
})
export class HeaderMenuComponent {

}
