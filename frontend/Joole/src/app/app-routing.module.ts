import { AuthGuard } from './services/auth-guard/auth-guard.service';
import { SignupComponent } from './components/signup/signup.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProductsComponent } from './components/products/products.component';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { CompareComponent } from './components/compare/compare.component';
import { NotFoundComponent } from './components/not-found/not-found.component';


const routes: Routes = [
  {
    path : '',
    component: HomeComponent
  },
  {
    path : 'signup',
    component: SignupComponent
  },
  {
    path : 'products',
    component: ProductsComponent,
    canActivate : [AuthGuard]
  },
  {
    path : 'product/:id',
    component: ProductDetailComponent,
    canActivate : [AuthGuard]
  },
  {
    path : 'compare/:data',
    component: CompareComponent,
    canActivate : [AuthGuard]
  },
  {
    path : '**',
    component: NotFoundComponent
  }
  
];

@NgModule({

  declarations: [],

  imports: [
    RouterModule.forRoot(routes),
  ],

  exports: [RouterModule]
})
export class AppRoutingModule { }
