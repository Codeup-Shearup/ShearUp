// This one works with creating a service and uploading an image

const client = filestack.init("ADslPh9z8SayE48tyD5Q9z");

const options = {
    onUploadDone: saveLocation
};
client.picker(options).open();

function saveLocation(resp){
    console.log(resp);
    // do some error handling and such here like fileError > filesuploaded[0]
    const photo = resp.filesUploaded[0];
    document.getElementById("imageUpload").value = photo.handle;

    document.getElementById("imagePreview").src = "https://cdn.filestackcontent.com/" + photo.handle;
}