<template>

    <v-data-table
        :headers="headers"
        :items="dashBoard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DashBoardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "filename", value: "filename" },
                { text: "filesize", value: "filesize" },
                { text: "path", value: "path" },
                { text: "filetype", value: "filetype" },
                { text: "isIndexed", value: "isIndexed" },
                { text: "isUploaded", value: "isUploaded" },
                { text: "url", value: "url" },
            ],
            dashBoard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/dashBoards'))

            temp.data._embedded.dashBoards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.dashBoard = temp.data._embedded.dashBoards;
        },
        methods: {
        }
    }
</script>

