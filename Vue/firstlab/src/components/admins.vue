<template>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Age</th>
        <th scope="col">Address</th>
        <th scope="col">Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for=" adm, index in admin" :key="adm.userName">
        <td>{{ index }}</td>
        <td>{{ adm.userName }}</td>
        <td>{{ adm.age }}</td>
        <td>{{ adm.add }}</td>
        <td><button @click="$emit('delete', index)">Delete</button></td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "AdminVue",
  data() {
    return {
    };
  },
  inject: ["admin"]
};
</script>

<style>
</style>