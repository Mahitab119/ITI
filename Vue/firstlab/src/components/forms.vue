<template>
  <div class="container-fluid">
    <div class="col-6 offset-3">
    <button type="button" @click="choice = 1" class="btn btn-primary mb-2">
      Form
    </button>
    <button type="button" @click="choice = 3" class="btn btn-primary ms-2 mb-2">
      Students
    </button>
    <button type="button" @click="choice = 2" class="btn btn-primary ms-2 mb-2">
      Admins
    </button>

    <div class="row align-items-center" v-if="choice == 1">
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
        <label class="btn btn-outline-primary ms-2" for="btnradio2">Admin</label>
        <div>
          <button type="submit" class="btn btn-primary mt-3">
            Add User
          </button>
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
export default {
  name: "FormVue",
  components: {
    AdminVue,
    StudentVue,
  },
  data() {
    return {
      choice: 1,
      type:"",
      formValues: {
        userName: "",
        age: "",
        add: "",
      },
      admins: [],
      students: [],
    };
  },
  provide() {
    return {
      std: this.students,
      admin: this.admins,
    };
  },
  methods: {
    insert(e) {
        e.preventDefault();
        if(this.type == 'student'){
             this.students.push(this.formValues);
        }
        else {
             this.admins.push(this.formValues);
        }
    },
    deleteStudent(index){
        this.students.splice(index,1)
    },
    deleteAdmin(index){
        this.admins.splice(index,1)
    }
  },
};
</script>

<style>
</style>