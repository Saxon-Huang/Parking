var app = new Vue({
    el: "#menu",
    data: {},
    methods: {
        getNodes: function () {
            $.ajax({
                url: "menu/get/nodes.json",
                type: "get",
                data: {},
                dataType: "json",
                async: false,
                success: function (response) {
                    console.log(response.data);

                },
                error: function (response) {
                    console.log(response);
                }
            })
        }
    },
})