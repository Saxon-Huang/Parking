var app = new Vue({
    el: "#admin-main-body",
    data: {
        admins: "${requestScope.pageInfo.list}",
    },

    methods: {
        showPageInfo: function () {
            console.log(${requestScope.pageInfo.list});
        }
    },
})