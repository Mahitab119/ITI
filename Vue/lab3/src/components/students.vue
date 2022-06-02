<template>
  <div class="container-fluid">
    <div class="col-6 offest-3 m-auto">
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
          <tr v-for="(student, index) in std" :key="student.userName">
            <td>{{ index }}</td>
            <td>{{ student.userName }}</td>
            <td>{{ student.age }}</td>
            <td>{{ student.add }}</td>
            <td><button @click="$emit('delete', index)">Delete</button></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { inject } from "vue";
export default {
  name: "StudentVue",
  setup() {
      const std = inject("std");
    return {
      std,
    };
  },
};
</script>

<style>
</style>