const client = filestack.init(FILESTACK_KEY);
const options = {
    onUploadDone: saveLocation
};
client.picker(options).open();

function saveLocation(resp){
    console.log(resp);
    // do some error handling and such here
    const photo = resp.filesUploaded[0];
    document.getElementById("imageUpload").value = photo.handle;

}