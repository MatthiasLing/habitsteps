<template>
    <div class = "habit-item" v-bind:class="{'is-complete':habit.completed
    }">

    <button class="btn btn-primary" @click="add" style="width:300px">

        <input type = "checkbox" @change="$emit('toggleComplete', habit.id)"/> 
        <h3>{{habit.title}}</h3>
        <p>{{habit.notes}}</p>
    </button>
    </div> 
</template>

<script>

export default {
    name: "HabitItem",
    props: ["habit"]
}
</script>

<style scoped>
    .habit-item{
        background: lightgoldenrodyellow;
        padding: 5px;
        border-bottom: 1px black dotted;
        width: 300px;
    }

    .is-complete {
        text-decoration: line-through;
        opacity: 0.6;
    }
</style>