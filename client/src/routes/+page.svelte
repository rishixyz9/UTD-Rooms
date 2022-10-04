<script>
	import Searchbar from "../components/Searchbar.svelte";

</script>
  
  <main>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com"/>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet"/>
    <link href="/styles/app.css" rel="stylesheet" type="text/css"/>
  
    <div class="container">
      <div class="flex-item box-1">
        <p class="main"><strong>UTD </strong>ROOMS</p>
        <p class="subtext">find open rooms anywhere on campus</p>
        <Searchbar />


      </div>
      <div class="flex-item box-2">
        <p class="bottom-text">Created by Rishabh Vemparala and Raghav Pillai</p>
        <div class="row-container">
          <p class="bottom-text">Suggestions? Open an issue here </p>
          <a rel="noopener noreferrer" href="https://github.com/rishixyz9/UTD-Rooms" target="_blank"><img src="/images/icons8-github.svg" alt=""/>
        </div>
  
      </div>
  
    </div>
  
  </main>
  
  <style>
    img {
      width: 5em;
      height: 5em;
    }
  
  </style>