let movies = [
    {
        name: "loki",
        des:
          "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus officia adipisci autem mollitia quidem totam.",
        image: "images/slider 1.PNG"
    },
  {
    name: "falcon and the winter soldier",
    des:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus officia adipisci autem mollitia quidem totam.",
    image: "images/slider 2.PNG"
  },
  {
    name: "wanda vision",
    des:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus officia adipisci autem mollitia quidem totam.",
    image: "images/slider 3.PNG"
  },
  {
    name: "raya and the last dragon",
    des:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus officia adipisci autem mollitia quidem totam.",
    image: "images/slider 4.PNG"
  },
  {
    name: "luca",
    des:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus officia adipisci autem mollitia quidem totam.",
    image: "images/slider 5.PNG"
  }
];


const carousel=document.querySelector('.carousel');
let sliders = [];
let slideIndex=0; //for track of current slide

const createSlide = () => {
    if(slideIndex >= movies.length){
        slideIndex=0;
    }

    // creating DOM elements
    let slide= document.createElement('div');
    var img= document.createElement('img');
    let content= document.createElement('div');
    let h1= document.createElement('h1');
    let p= document.createElement('p');

    // attaching all elements
    img.appendChild(document.createTextNode(''));
    h1.appendChild(document.createTextNode(movies[slideIndex].name));
    p.appendChild(document.createTextNode(movies[slideIndex].des));
    content.appendChild(h1);
    content.appendChild(p);
    slide.appendChild(content);
    slide.appendChild(img);
    carousel.appendChild(slide);
    // console.log(title);

    // setting up images
    img.src=movies[slideIndex].image;
    slideIndex++;

    //setting up class names
    slide.className="slider";
    content.className="slider_content";
    h1.className="title";
    p.className="description";

    sliders.push(slide);

    if(sliders.length)
    {
        sliders[0].style.marginLeft = `calc(-${100*(sliders.length-2)}% - ${30*(sliders.length-2)}px)`;
        }
}
for(let i=0; i<3; ++i){
    createSlide();
}
setInterval(() => {
    createSlide();
}, 3000);


// video cards
const videoCards=[...document.querySelectorAll(".card")];
console.log(videoCards);
videoCards.forEach((item) => {
    item.addEventListener('mouseover',()=>{
        let video = item.children[1];
        video.play();
    });

    item.addEventListener('mouseleave',()=>{
        let video = item.children[1];
        video.pause();
    });
})



