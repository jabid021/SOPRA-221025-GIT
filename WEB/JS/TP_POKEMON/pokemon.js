//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var pokemonChoisi;
var currentSprite;
var direction="Down";
var boundaryX = 700 //for a 700px*700px square map
var boundaryY = 700 //


inputName.onkeyup=function(event)
{
  if(inputName.value=="")
  {
    btnStart.disabled=true;
  }
  else{
    btnStart.disabled=false;
    if(event.key=="Enter")
    {
      lancerAventure();
    }

  }

}

btnStart.onclick=lancerAventure;


function lancerAventure()
{
  formStart.style.display="none";
  grass.style.display="block";
  pokemonAffiche.setAttribute("title",inputName.value);

  theme.volume=0.05;
  theme.play();
  console.log(theme);
  console.log(theme.volume);


  pokemonChoisi = (radioPokemon.checked) ? "pikachu" : "coincoin";
  currentSprite = pokemonChoisi;
  imgPokemon.setAttribute("src","assets2/img/" + currentSprite + direction + ".png");

  document.body.onkeyup=deplacement;
}


function move(direction, distance = 30, traverser = false)
{
  imgPokemon.setAttribute("src","assets2/img/"+ currentSprite +direction+".png");
  let spriteWidth = imgPokemon.width;
  let spriteHeight = imgPokemon.height;
  let surTerre = (posX>=0 && posX<boundaryX) && (posY>=0 && posY<boundaryY);
  let downCollision = (surTerre && (posY + spriteHeight + distance > boundaryY)) || (!surTerre && posX>=0 && posX<boundaryX && posY <0 && (posY + spriteHeight + distance >0));
  let upCollision = (surTerre && (posY - distance < 0)) || (!surTerre && posX>=0 && posX < boundaryX && posY >= boundaryY && (posY - distance < boundaryY));
  let rightCollision = (surTerre && (posX + spriteWidth + distance > boundaryX)) || (!surTerre && posY>=0 && posY<boundaryY && posX < 0 && (posX + spriteWidth + distance > 0));
  let leftCollision = (surTerre && (posX - distance <0)) || (!surTerre && posY>=0 && posY<boundaryY && posX >= boundaryX && (posX - distance < boundaryX));


  switch(direction){
  case 'Down':
    console.log("surTerre " + surTerre);
    if(!downCollision)
    {
      posY = posY + distance;
    }
    else
    {
      console.log("downCollision");
      let msg = surTerre ? "Surfer?" : "Revenir à Terre";
      if(confirm(msg)) {
       currentSprite = surTerre ? "surf" : pokemonChoisi;
       imgPokemon.setAttribute("src","assets2/img/"+ currentSprite +direction+".png");
       let audioSwitch = surTerre? "assets2/audio/surftheme.mp3" : "assets2/audio/theme.mp3";
       theme.setAttribute("src",audioSwitch);
       theme.play();
       posY = surTerre ? boundaryY : 0;
     }
   }
   break;

 case 'Up':
  console.log("surTerre " + surTerre);
  if(!upCollision)
  {
    posY = posY - distance;
  }
  else
  {
    console.log("upCollision");
    let msg = surTerre ? "Surfer?" : "Revenir à Terre";
    if(confirm(msg)) {
     currentSprite = surTerre ? "surf" : pokemonChoisi;
     imgPokemon.setAttribute("src","assets2/img/"+ currentSprite +direction+".png"); 
     let audioSwitch = surTerre? "assets2/audio/surftheme.mp3" : "assets2/audio/theme.mp3";
     theme.setAttribute("src",audioSwitch);
     theme.play();
     posY = surTerre ? -(spriteHeight) : boundaryY - spriteHeight;
   }
 }
 break;

 case 'Right':
  console.log("surTerre " + surTerre);
  if(!rightCollision)
  {
    posX = posX + distance;
  }
  else
  {
    console.log("rightCollision");
    let msg = surTerre ? "Surfer?" : "Revenir à Terre";
    if(confirm(msg)) {
     currentSprite = surTerre ? "surf" : pokemonChoisi;
     imgPokemon.setAttribute("src","assets2/img/"+ currentSprite +direction+".png");
     let audioSwitch = surTerre? "assets2/audio/surftheme.mp3" : "assets2/audio/theme.mp3";
     theme.setAttribute("src",audioSwitch);
     theme.play();
     posX = surTerre ? boundaryX : 0;
   }
 }
 break;
 case 'Left':
  console.log("surTerre " + surTerre);
  if(!leftCollision)
  {
    posX = posX - distance;
  }
  else
  {
    console.log("leftCollision");
    let msg = surTerre ? "Surfer?" : "Revenir à Terre";
    if(confirm(msg)) {
     currentSprite = surTerre ? "surf" : pokemonChoisi;
     imgPokemon.setAttribute("src","assets2/img/"+ currentSprite +direction+".png");
     let audioSwitch = surTerre? "assets2/audio/surftheme.mp3" : "assets2/audio/theme.mp3";
     theme.setAttribute("src",audioSwitch);
     theme.play();
     posX = surTerre ? -(spriteWidth) : boundaryX - spriteWidth;
   }
  }
 break;}
}

function deplacement(event)
{
  switch(event.key){
  case "ArrowDown": 
  case "s":
    move("Down");break;

  case "ArrowRight":
  case "d":
   move("Right");break;


 case "ArrowLeft":
 case "q":
  move("Left");break;

case "ArrowUp":
case "z":
  move("Up");break;
}

pokemonAffiche.style.top=posY+"px";
pokemonAffiche.style.left=posX+"px";
}
