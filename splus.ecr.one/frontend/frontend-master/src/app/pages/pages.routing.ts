import { Routes, RouterModule }  from '@angular/router';
import { Pages } from './pages.component';
import { ModuleWithProviders } from '@angular/core';
// noinspection TypeScriptValidateTypes

// export function loadChildren(path) { return System.import(path); };

export const routes: Routes = [
  {
    path: 'login',
    loadChildren: 'app/pages/login/login.module#LoginModule'
  },
  
  {
    path: 'pages',
    component: Pages,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },
      { path: 'forms', loadChildren: './forms/forms.module#FormsModule' },
      { path: 'tables', loadChildren: './tables/tables.module#TablesModule' },
      { path: 'inventory', loadChildren: './inventory/inventory.module#InventoryModule' },
      { path: 'search', loadChildren: './search/search.module#SearchModule' },
      { path: 'transaction', loadChildren: './transaction/transaction.module#TransactionModule' },
      { path: 'booking', loadChildren: './booking/booking.module#BookingModule' }
      
      
    ]
  }
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
