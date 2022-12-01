//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;

var pokemon="pikachu";
var direction="Down";
var terrain="ground";

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
  pikachu.setAttribute("title",inputName.value);

  theme.volume=0.05;
  theme.play();
  console.log(theme);
  console.log(theme.volume);


  pokemon=(radioPikachu.checked) ? "pikachu" : "coincoin";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

  document.body.onkeyup=deplacement;
}



function deplacement(event)
{
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    if(posY<=630)
    {
      posY+=30;
    }
    direction="Down";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    if(posX<=630)
    {
      posX+=30;
    }
    direction="Right";
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    if(posX>=30)
    {
      posX-=30;
    }
    direction="Left";
  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    if(posY>=30)
    {
      posY-=30;
    }
    direction="Up";
  }


  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

}
