const tr = new FilestackTransform(FILESTACK_KEY,clientOptions);
tr.open('https://cdn.filestackcontent.com/enhance=preset:outdoor/security=p:eyJjYWxsIjogWyJjb252ZXJ0IiwgInJlYWQiXSwgImV4cGlyeSI6IDE4ODEyNTc3MDksICJoYW5kbGUiOiAiWG9UTjdUTXdRN0sxYWl6Q0pBOWQifQ==,s:441284b4ac5e390bf269a48b51fd740a5515cf9c6290a91e51f2821bfb1a6c61/XoTN7TMwQ7K1aizCJA9d').then(res => {
    document.getElementById('result').src = res
});



// function updatePhotoForm(result) {
//     const fileData = result.filesUploaded[0];
//     photoInput.value = fileData.url; //this is the good part
//     console.log(fileData.url);
//     console.log(photoInput.value);
// }

