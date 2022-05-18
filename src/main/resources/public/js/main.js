// Check if the path is "/auction/1" and open the modal
if (window.location.pathname.split("").find(x => x === "/").length === 1) {
    $(document).ready(function () {
        $("#modalView").modal('show');
    });
}

const openUrl = (url) => {
    window.location.assign(url)
}

const approveBid = (url) => {
    console.log(url);
    fetch(url, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => console.log("Patched")).catch(error => console.error('Error:', error))
}