import axios from "axios";


async function getLikesCount(id) {
    let res = axios.get(`http://localhost:8080/api/song/likes/${id}`);

    return (await res).data;
}

export default getLikesCount;