<template>
  <div>
    <h2>Liste des joueurs</h2>
    <PlayerTable :players="players" />
  </div>
</template>

<script>
import PlayerTable from '../components/PlayerTable.vue';
import { getPlayers } from '../services/api.js';

export default {
  components: { PlayerTable },
  data() {
    return { players: [] };
  },
  async mounted() {
    this.players = await getPlayers();
  }
};
</script>
