<script>
  import  buildings  from '../../../../server/ClassData/output.json';
  export let data
  console.log(data)
</script>
  
<main>
  <link rel="preconnect" href="https://fonts.googleapis.com"/>
  <link rel="preconnect" href="https://fonts.gstatic.com"/>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet"/>
  <link href="/styles/app.css" rel="stylesheet" type="text/css"/>

  <div class="container">
    <div class="flex-item box-1">
      <p class="main">Results For <strong>"{data['bldg']}"</strong></p>
    </div>
  </div>

</main>