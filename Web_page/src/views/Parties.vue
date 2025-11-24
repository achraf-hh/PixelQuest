<template>
  <div>
    <h2>Liste des parties</h2>
    <PartyTable :parties="parties" />
  </div>
</template>

<script>
import PartyTable from '../components/PartyTable.vue';
import { getParties } from '../services/api.js';

export default {
  components: { PartyTable },
  data() {
    return { parties: [] };
  },
  async mounted() {
    this.parties = await getParties();
  }
};
</script>
