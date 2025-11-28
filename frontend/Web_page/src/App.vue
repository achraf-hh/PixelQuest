<template>
  <div class="min-h-screen bg-gray-100 font-sans">
    <!-- Header -->
    <header class="bg-gradient-to-r from-indigo-600 to-purple-600 text-white p-6 shadow-lg flex flex-col md:flex-row justify-between items-center">
      <h1 class="text-3xl font-bold tracking-wide mb-4 md:mb-0">ESP32 Dashboard</h1>
      <nav>
        <router-link
          to="/players"
          class="px-4 py-2 rounded-lg bg-white text-indigo-600 font-semibold hover:bg-indigo-100 transition mr-2"
          >Players</router-link
        >
        <router-link
          to="/parties"
          class="px-4 py-2 rounded-lg bg-white text-purple-600 font-semibold hover:bg-purple-100 transition"
          >Parties</router-link
        >
      </nav>
    </header>

    <!-- Content -->
    <main class="p-8 max-w-7xl mx-auto space-y-8">
      <router-view />
    </main>
  </div>
</template>

<script>
export default {};
</script>
