export const PAGES_MENU = [
  {
    path: 'pages',
    children: [
      {
        path: 'dashboard',
        data: {
          menu: {
            title: 'general.menu.dashboard',
            icon: 'ion-android-home',
            selected: false,
            expanded: false,
            order: 0
          }
        }
      },
      {
        path: 'inventory',
        data: {
          menu: {
            title: 'general.menu.inventory',
            icon: 'ion-edit',
            selected: false,
            expanded: false,
            order: 120
          }
        }
      },
      {
        path: 'search',
        data: {
          menu: {
            title: 'general.menu.search',
            icon: 'ion-search',
            selected: false,
            expanded: false,
            order: 130
          }
        }
      },
      {
        path: 'transaction',
        data: {
          menu: {
            title: 'general.menu.transaction',
            icon: 'ion-gear-a',
            selected: false,
            expanded: false,
            order: 140
          }
        }
      }, 
      {
        path: 'booking',
        data: {
          menu: {
            title: 'general.menu.booking',
            icon: 'ion-folder',
            selected: false,
            expanded: false,
            order: 140
          }
        }
      }
    ]
  },
  {
path: 'login',
data: {
  menu: {
    title: 'general.menu.login',
    icon: 'ion-document',
    selected: false,
    expanded: false,
    order: 650
  }
}
}
];
