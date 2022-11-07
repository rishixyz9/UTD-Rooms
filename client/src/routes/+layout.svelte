<script>
    import { onMount } from "svelte"

    let loading = true;
    onMount(() => {
        loading = false;
    }) 


</script>

{#if loading}
    <div class="loader-container">
        <svg class="loader">
            <rect class="side-1"></rect>
            <rect class="side-2" x="0%" y="92.5%"></rect>
            <rect class="side-3" x="92.5%" y="100%"></rect>
            <rect class="side-4" x="100%" y="0%"></rect>
        </svg>
        <p class="loading">Loading</p>
    </div>
{/if}

<slot />

<style>
    .loader-container {
        position: fixed;
        width: 100%;
        height: 100%;
        background-color: rgb(0, 0, 0);
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        z-index: 9999;
    }

    .loader {
        display: flex;
        justify-content: center;
        width: 10%;
        aspect-ratio: 1/1;
        height: auto;
        fill: white;
    }

    .loading {
        font-size: 3em;
        color: white;
    }

    .side-1 {
        height: 0%;
        width: 7.5%;
        animation: increase-1 10s forwards infinite;
    }

    .side-2 {
        height: 7.5%;
        width: 0%;
        animation: increase-2 10s forwards infinite;
        animation-delay: 1s;
    }

    .side-3 {
        height: 100%;
        width: 7.5%;
        animation: increase-3 10s forwards infinite;
        animation-delay: 2s;
        
    }
    
    .side-4 {
        height: 7.5%;
        width: 100%;
        animation: increase-4 10s forwards infinite;
        animation-delay: 3s;
    }

    @keyframes increase-1 {
        0% {
            height: 0%;
        }
        
        10%, 40% {
            height: 100%;
        }

        50%, 100% {
            height: 0%;
        }
    }

    @keyframes increase-2 {
        0% {
            width: 0%;
        }

        10%, 40% {
            width: 100%;
        }
        
        50%, 100%  {
            width: 0%;
        }
    }

    @keyframes increase-3 {
        0% {
            y: 100%;
        }
        
        10%, 40% {
            y: 0%;
        }

        50%, 100%  {
            y: 100%
        }
    }

    @keyframes increase-4 {
        0% {
            x: 100%;
        }

        10%, 40% {
            x: 0%;
        }
        
        50%, 100% {
            x: 100%;
        }
    }

    @keyframes spin {
        0% {
            transform:rotate(0deg);
        }
        100% {
            transform:rotate(270deg);
        }
    }

</style>