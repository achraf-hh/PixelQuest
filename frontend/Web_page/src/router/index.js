import { createRouter, createWebHistory } from 'vue-router';

import Players from '../views/Players.vue';
import Parties from '../views/Parties.vue';

const routes = [
  { path: '/', redirect: '/players' },
  { path: '/players', name: 'Players', component: Players },
  { path: '/parties', name: 'Parties', component: Parties }
];

export default createRouter({
  history: createWebHistory(),
  routes
});
