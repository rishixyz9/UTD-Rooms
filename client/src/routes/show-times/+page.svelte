<script>
  import  buildings  from '../../../../server/ClassData/output.json';
  import Timeline from '../../components/Timeline.svelte';
  import Searchbar from "../../components/Searchbar.svelte";
  export let data
  function handlesubmit(event){
    if(event.key == 'Enter'){
      const input = document.getElementById('input').value
      document.getElementById('input').value = ''
      window.location = `/show-times?bldg=${input.toUpperCase()}`;
    }
  }

  // console.log(data)
</script>
  
<main>
  <link rel="preconnect" href="https://fonts.googleapis.com"/>
  <link rel="preconnect" href="https://fonts.gstatic.com"/>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet"/>
  <link href="/styles/app.css" rel="stylesheet" type="text/css"/>
  <link href="/styles/results.css" rel="stylesheet" type="text/css"/>

  <div class="container">
    <div class="row-container w-3">
      <p class="main">Results For <strong>"{data['bldg']}"</strong></p>
      <input class="searchbar" placeholder="Need a spot somewhere else?" 
      type="text" id="input" on:keydown={handlesubmit}/>
      <a class="home-icon" href="/"><img src="/images/home-icon.png" alt=""/></a>
    </div>
    <Timeline data={data}/>
  </div>

</main>