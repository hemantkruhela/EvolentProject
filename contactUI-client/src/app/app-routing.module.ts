import { CreateContactComponent } from './create-contact/create-contact.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactListComponent } from './contact-list/contact-list.component';
import { UpdateContactComponent } from './update-contact/update-contact.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
    {path: '', component: LoginComponent},
  { path: 'contacts', component: ContactListComponent },
  { path: 'add', component: CreateContactComponent },
  { path: 'update/:id', component: UpdateContactComponent },  
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
