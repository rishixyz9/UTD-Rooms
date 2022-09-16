<script>
    export let data;
    const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
    const date = new Date();

    function getRoomStatus(room){
        if(data['res'][room][days[date.getDay()]]){
            for(let i=0; i < data['res'][room][days[date.getDay()]].length; i++)
                var times = data['res'][room][days[date.getDay()]][i].split(' - ');
                const start = new Date(`${date.getMonth()+1}/${date.getDate()}/${date.getFullYear()} ` + times[0])
                const end = new Date(`${date.getMonth()+1}/${date.getDate()}/${date.getFullYear()} ` + times[1])
                if(date >= start && date <= end){
                    return 'Closed'
                }
        }
        return 'Open'
    }

    const rooms = Object.keys(data['res']).map((key) => [key]);

</script>

<main>
    <link href="/styles/app.css" rel="stylesheet" type="text/css"/>
    <link href="/styles/results.css" rel="stylesheet" type="text/css"/>

    <div class="spacer"></div>
    {#if data['status'] == '200'}
        {#each rooms as key}
            <div class="room-container">
                <div class="room">
                    <div class="label">{key}</div>
                    <div class="label">Status: <strong>{getRoomStatus(key)}</strong></div>
                    <div class="indicator {getRoomStatus(key)}"></div>
                </div>
            </div>

        {/each}
    {:else}
        <div class="room-container" style="font-size: 6em;">No results for {data['bldg']}</div>
    
    {/if}
    

</main>

<style>
    .room-container {
        width: 100%;
        display: flex;
        flex-direction: row;
        justify-content: center;
        margin-bottom: 1em;
        text-align: center;
        justify-content: center;
    }

    .room:hover{
        transition: all 0.1s ease-in-out;
        border-color: rgb(0, 153, 255);
        box-shadow: 0px 0px .2em 0px rgb(0, 153, 255);
    }

    .room {
        display: flex;
        flex-direction: row;
        gap: 45%;
        border: solid;
        border-width: .1em;
        border-radius: 1em;
        width: 75%;
        align-items: center;
        padding-left: 1em;
        padding-right: 1em;
    }

    .label {
        font-size: 2em;
        margin: 0;
        width: 2%;
    }

    .indicator {
        width: 1em;
        height: 1em;
        border: solid;
        border-radius: 1em;
    }

    .indicator.Closed {
        border-color: red;
        background-color: red;
    }

    .indicator.Open {
        border-color: rgb(0, 194, 0);
        background-color: rgb(0, 194, 0);
    }

    .spacer {
        margin: 1em;
    }

</style>