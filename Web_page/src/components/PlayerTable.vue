<template>
  <div class="bg-white shadow-lg rounded-lg overflow-hidden border border-gray-200">
    <div class="p-4 bg-indigo-50 font-bold text-indigo-700 text-lg">Liste des joueurs</div>
    <table class="min-w-full divide-y divide-gray-200">
      <thead class="bg-indigo-100 text-indigo-900">
        <tr>
          <th class="px-6 py-3 text-left">ID</th>
          <th class="px-6 py-3 text-left">Pseudo</th>
        </tr>
      </thead>
      <tbody class="bg-white divide-y divide-gray-200">
        <tr
          v-for="p in players"
          :key="p.id"
          class="hover:bg-indigo-50 transition-colors"
        >
          <td class="px-6 py-3">{{ p.id }}</td>
          <td class="px-6 py-3">{{ p.username }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: ['players']
};
</script>
