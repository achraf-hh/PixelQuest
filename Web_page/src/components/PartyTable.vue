<template>
  <div class="bg-white shadow-lg rounded-lg overflow-hidden border border-gray-200">
    <div class="p-4 bg-purple-50 font-bold text-purple-700">Liste des parties</div>
    <table class="min-w-full divide-y divide-gray-200">
      <thead class="bg-purple-100 text-purple-900">
        <tr>
          <th class="px-6 py-3 text-left">ID</th>
          <th class="px-6 py-3 text-left">Nom de la partie</th>
          <th class="px-6 py-3 text-left">Nombre de joueurs</th>
        </tr>
      </thead>
      <tbody class="bg-white divide-y divide-gray-200">
        <tr
          v-for="party in parties"
          :key="party.id"
          class="hover:bg-purple-50 transition-colors"
        >
          <td class="px-6 py-3">{{ party.id }}</td>
          <td class="px-6 py-3">{{ party.name }}</td>
          <td class="px-6 py-3">{{ party.playersCount }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: ['parties']
};
</script>
