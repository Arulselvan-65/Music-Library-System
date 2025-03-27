import axios from "axios";
import { toast } from "react-toastify";


async function addSong(formData) {
    let res = await axios.post("http://localhost:8080/api/songs/addsong", {
        title: formData.title,
        artist: formData.artist,
        genre: formData.genre,
        slink: formData.slink
      })
  
      if(res.data === "Song added Successfully"){
        toast.success("Song Added Successfully!!!", {autoClose: 1000});
        setTimeout(() =>  window.location.reload(), 1500);
       
      }
  
      console.log(formData);
}

export default addSong;