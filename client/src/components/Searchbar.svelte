<script>
    const buildings = ["SOM", "AD", "JO", "CRA", "CR", "GR", "FN", "FO", "CB", "MC", "ATC", "HH", "ML2", "SLC", "RHW", "ROW", "SP2", "ECSS", "ECSW", "CD1", "CD2", "CB3", "RNHW", "SCI", "ML1", "ECSN", "SPN", "AH2", "CHEC", "ROC", "PHY", "TH"]
    let recs = []

    function handleChange(){
      let input = document.getElementById('input').value
      if(input)
        recs = recommend(input)
      else
        recs = []
    }

    function recommend(input){
      var res = []
      for(const bldg in buildings){
        if(input.toUpperCase() === buildings[bldg].substring(0, input.length)){
          res.push(buildings[bldg])
        }
      }
      return res
    }

    function handlesubmit(event){
      if(event.key == 'Enter'){
        const input = document.getElementById('input').value
        document.getElementById('input').value = ''
        window.location = `/show-times?bldg=${input.toUpperCase()}`;
      }
    }

</script>

<main>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com"/>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet"/>
    <link href="/styles/app.css" rel="stylesheet" type="text/css"/>
    
    <div class="search-wrapper">
        <input class="searchbar" placeholder="Where do you want to find a spot?" 
        type="text" id="input" on:keydown={handlesubmit} on:input={handleChange}/>


        {#if recs.length > 0}
            <div class="rec-box">
            {#each recs as key}
                <div class="rec-item">
                    {key}
                </div>
            {/each}
            </div>
        {/if}
    </div>
</main>