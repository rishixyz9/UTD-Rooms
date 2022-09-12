import { error } from '@sveltejs/kit';
import  buildings  from '../../../../server/ClassData/output.json';

/** @type {import('./$types').PageServerLoad} */
export function load({ url }) {
    const res = buildings[url.searchParams.get('bldg')];

    if (res) {
      return({
        bldg: url.searchParams.get('bldg'), 
        res: res});
    }
   
    throw error(404, 'Not found');
}