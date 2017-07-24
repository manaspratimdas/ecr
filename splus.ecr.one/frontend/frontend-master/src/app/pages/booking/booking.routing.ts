import { Routes, RouterModule }  from '@angular/router';

import { Booking } from './booking.component';
import { Layouts } from '../../pages/forms/components/layouts/layouts.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: Booking,
    children: [
      { path: 'layouts', component: Layouts }
    ]
  }
];

export const routing = RouterModule.forChild(routes);
