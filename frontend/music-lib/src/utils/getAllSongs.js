
import axios from "axios";

async function getAllSongs() {

    let res = axios.get("http://localhost:8080/api/songs/");

    console.log((await res).data);
}

export default getAllSongs;