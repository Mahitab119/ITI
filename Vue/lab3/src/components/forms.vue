<template>
  <div class="container-fluid">
    <div class="col-6 offset-3">
      <button type="button" @click="choice = 1" class="btn btn-primary mb-2">
        Form
      </button>
      <button
        type="button"
        @click="choice = 3"
        class="btn btn-primary ms-2 mb-2"
      >
        Students
      </button>
      <button
        type="button"
        @click="choice = 2"
        class="btn btn-primary ms-2 mb-2"
      >
        Admins
      </button>

      <div class="row" v-if="choice == 1">
        <form @submit.prevent="insert">
          <div class="input-group mb-3">
            <input
              type="text"
              name="name"
              class="form-control"
              placeholder="Username"
              aria-label="Username"
              aria-describedby="basic-addon1"
              v-model="formValues.userName"
              ref="inputref"
            />
          </div>
          <div class="input-group mb-3">
            <input
              name="age"
              type="text"
              class="form-control"
              placeholder="Age"
              v-model="formValues.age"
            />
          </div>
          <div class="input-group mb-3">
            <input
              name="address"
              type="text"
              class="form-control"
              placeholder="Address"
              v-model="formValues.add"
            />
          </div>
          <input
            type="radio"
            class="btn-check"
            name="type"
            value="student"
            v-model="type"
            id="btnradio1"
            autocomplete="off"
          />
          <label class="btn btn-outline-primary" for="btnradio1">Student</label>
          <input
            type="radio"
            class="btn-check"
            name="type"
            value="admin"
            v-model="type"
            id="btnradio2"
            autocomplete="off"
          />
          <label class="btn btn-outline-primary ms-2" for="btnradio2"
            >Admin</label
          >
          <div>
            <button type="submit" class="btn btn-primary mt-3">Add User</button>
          </div>
        </form>
      </div>
    </div>
  </div>

  <AdminVue v-if="choice == 2" @delete="deleteAdmin" />
  <StudentVue v-if="choice == 3" @delete="deleteStudent" />
</template>

<script>
import AdminVue from "./admins.vue";
import StudentVue from "./students.vue";
import { ref,onMounted,provide } from "vue";

export default {
  name: "FormVue",
  components: {
    AdminVue,
    StudentVue,
  },
  setup() {
    const inputref=ref(null)
    const choice = ref(1);
    const formValues = ref({ name: "", age: "", address: "" });
    const type = ref("");
    const admins = ref([]);
    const students = ref([]);
    onMounted(()=>{
      inputref.value.focus()
    })
    function insert(e) {
      e.preventDefault();
      if (type.value == "student") {
        students.value.push(formValues.value);
      } else {
        admins.value.push(formValues.value);
      }
    }
    function deleteStudent(index) {
      students.value.splice(index, 1);
    }

    function deleteAdmin(index) {
      admins.value.splice(index, 1);
    }

    provide('std',students)
    provide('admin',admins)

    return {
      choice,
      formValues,
      type,
      admins,
      students,
      insert,
      deleteStudent,
      deleteAdmin,
      inputref
    }
  },
};
</script>

<style>
</style>