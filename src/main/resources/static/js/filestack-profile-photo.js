//THIS WILL BE FOR UPLOADING A PROFILE PHOTO


// // -------------- FILESTACK --------------
// window.addEventListener('DOMContentLoaded', function () {
//
//     // -------------- API KEY (Keys.js) --------------
//     const apikey = FILESTACK_KEY;
//     const client = FILESTACK_KEY.init(apikey);
//
//     // -------------- UPLOAD PREFERENCES --------------
//     const options = {
//         displayMode: 'inline',
//         container: '#inline',
//         maxFiles: 20,
//         uploadInBackground: false,
//         onUploadDone: function (res){
//             console.log(res);
//
//             console.log(res.filesUploaded[0].url);
//
//             let filestackUrl = `<input type="hidden" name="profileImageUrl" value="${res.filesUploaded[0].url}"/>`;
//
//             $("#editProfileForm").append(filestackUrl);
//         },
//     };
//
//     // -------------- FILE PICKER --------------
//     const picker = client.picker(options);
//
//     // -------------- HTML ELEMENTS --------------
//     const openBtn = document.getElementById('open');
//     const closeBtn = document.getElementById('close');
//
//     // -------------- EVENT LISTENERS --------------
//     openBtn.addEventListener('click', () => picker.open());
//     closeBtn.addEventListener('click', () => picker.close());
//
// });