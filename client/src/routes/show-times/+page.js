import { error } from '@sveltejs/kit';
import  buildings  from '../../../../server/ClassData/output.json';

/** @type {import('./$types').PageServerLoad} */
export function load({ url }) {
    const res = buildings[url.searchParams.get('bldg')];

    if (res) {
      return({
        bldg: url.searchParams.get('bldg'), 
        status: '200',
        res: res});
    }
    else{
      return({
        bldg: url.searchParams.get('bldg'),
        status: '404',
        res: 'Not Found'
      })
    }
   
    throw error(404, 'Not found');
}