<script setup>
// 从vue中 引入 ref 函数
import { ref, onMounted } from 'vue';

// 声明响应式数据
const count = ref(0);

// 声明一个函数 -- 组合式API中没有this, this的指向为undefined
function increment(){
  count.value++; // 操作的是ref中的值，而ref中只有一个值value，因此只能 count.value++;
};

// 引入钩子函数
onMounted(() => {
  console.log('Vue...mounted...');
});
</script>

<template>
  <button v-on:click="increment">count: {{ count }}</button>
</template>

<style scoped>

</style>